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

import drugikolok.app.dto.FinansijskaKarticaDTO;
import drugikolok.app.model.FinansijskaKartica;
import drugikolok.app.service.FinansijskaKarticaService;


@Controller
@CrossOrigin
@RequestMapping(path = "/finansijskaKartica")
public class FinansijskaKarticaCtrl {
	
	@Autowired
	FinansijskaKarticaService service;
	ArrayList<FinansijskaKarticaDTO> lista;
	
	//Dobavi sve
			@RequestMapping(path = "", method = RequestMethod.GET)
			public ResponseEntity<ArrayList<FinansijskaKarticaDTO>> dobaviSve(){
				ModelMapper mm = new ModelMapper();
				
				lista = new ArrayList<FinansijskaKarticaDTO>();
				for(FinansijskaKartica x:service.dobaviSve()) {
					lista.add(mm.map(x, FinansijskaKarticaDTO.class));
				}
				
				return new ResponseEntity<ArrayList<FinansijskaKarticaDTO>>(lista, HttpStatus.OK);
			}
			
			//Dobavi po ID
			@RequestMapping(path = "/{id}", method = RequestMethod.GET)
			public ResponseEntity<FinansijskaKarticaDTO> dobaviPoId(@PathVariable("id") Long id){
				ModelMapper mm = new ModelMapper();
				FinansijskaKartica postojeci = service.dobaviPoId(id);
				
				if(postojeci == null) {
					return new ResponseEntity<FinansijskaKarticaDTO>(HttpStatus.NOT_FOUND);
				}
				FinansijskaKarticaDTO obj = mm.map(postojeci, FinansijskaKarticaDTO.class);
				return new ResponseEntity<FinansijskaKarticaDTO>(obj, HttpStatus.OK);
				
			}
			
			//Dodavanje novog
			@RequestMapping(path = "", method = RequestMethod.POST)
		    public ResponseEntity<FinansijskaKartica> dodajNovi(@RequestBody FinansijskaKartica obj) {
		        if (service.dobaviPoId(obj.getId()) != null) {
		            return new ResponseEntity<FinansijskaKartica>(HttpStatus.CONFLICT);
		        }
		        service.save(obj);
		        return new ResponseEntity<FinansijskaKartica>(HttpStatus.OK);
		    }
			
			//Izmena
		    @RequestMapping(path = "", method = RequestMethod.PUT)
		    public ResponseEntity<FinansijskaKartica> izmeni(@RequestBody FinansijskaKartica obj) {
		    	FinansijskaKartica postojeci = service.dobaviPoId(obj.getId());
		        
		        if (postojeci == null) {
		            return new ResponseEntity<FinansijskaKartica>(HttpStatus.NOT_FOUND);
		        }
		        
		        
		        postojeci.setPozivNaBroj(obj.getPozivNaBroj());
		        
		        
		        
		        service.save(postojeci);
		        return new ResponseEntity<FinansijskaKartica>(HttpStatus.OK);
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
