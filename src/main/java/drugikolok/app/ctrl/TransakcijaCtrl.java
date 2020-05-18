package drugikolok.app.ctrl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import drugikolok.app.dto.TransakcijaDTO;
import drugikolok.app.model.Transakcija;
import drugikolok.app.service.TransakcijaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/transakcija")
public class TransakcijaCtrl {
	
	@Autowired
	TransakcijaService service;
	ArrayList<TransakcijaDTO> lista;
	
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<TransakcijaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<TransakcijaDTO>();
		for(Transakcija x:service.dobaviSve()) {
			lista.add(mm.map(x, TransakcijaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<TransakcijaDTO>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TransakcijaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Transakcija postojeci = service.dobaviPoId(id);
		
		if(postojeci == null) {
			return new ResponseEntity<TransakcijaDTO>(HttpStatus.NOT_FOUND);
		}
		TransakcijaDTO obj = mm.map(postojeci, TransakcijaDTO.class);
		return new ResponseEntity<TransakcijaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Transakcija> dodajNovi(@RequestBody Transakcija obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Transakcija>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Transakcija>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Transakcija> izmeni(@RequestBody Transakcija obj) {
    	Transakcija postojeci = service.dobaviPoId(obj.getId());
        
        if (postojeci == null) {
            return new ResponseEntity<Transakcija>(HttpStatus.NOT_FOUND);
        }
        
        
        postojeci.setDatumValute(obj.getDatumValute());;
        
        
        
        service.save(postojeci);
        return new ResponseEntity<Transakcija>(HttpStatus.OK);
    }

    //Brisanje
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
