// c:\Users\Lautaro\Documents\GitHub\Instrumentos-back-UTN-Lab4\src\main\java\com\example\instrumentos\controller\InstrumentoController.java
package intrumentos.utn.controller;

import intrumentos.utn.model.Instrumento;
import intrumentos.utn.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumentos")
@CrossOrigin(origins = "http://localhost:5173")
public class InstrumentoController {
    @Autowired
    private InstrumentoService service;

    @GetMapping
    public List<Instrumento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Instrumento getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Instrumento create(@RequestBody Instrumento instrumento) {
        return service.save(instrumento);
    }

    @PutMapping("/{id}")
    public Instrumento update(@PathVariable Long id, @RequestBody Instrumento instrumento) {
        instrumento.setId(id);
        return service.save(instrumento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}