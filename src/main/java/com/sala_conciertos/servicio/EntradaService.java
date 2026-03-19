package com.sala_conciertos.servicio;

import com.sala_conciertos.modelo.Entrada;
import com.sala_conciertos.modelo.TipoEntrada;
import com.sala_conciertos.modelo.TipoZona;
import com.sala_conciertos.repositorio.EntradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    private EntradaRepository repositorio;

    public EntradaService(EntradaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Entrada> listarTodas(){return repositorio.findAll();}

    @Transactional
    public Entrada guardar( Entrada entrada ){

        double precio = entrada.getEvento().getPrecioTaquilla();

        entrada.setPrecioTotal(precio);

        if(entrada.getTipoEntrada().equals(TipoEntrada.VIP)){
            entrada.setPrecioTotal(precio * 1.25);
        }else if(entrada.getTipoEntrada().equals(TipoEntrada.BENEFACTOR)){
            entrada.setPrecioTotal(precio * 1.1);
        }

        return repositorio.save(entrada);
    }

    @Transactional
    public void eliminar( Long id ){
        if(repositorio.existsById(id)) {
            repositorio.deleteById(id);
        }else{
            throw new RuntimeException("Entrada no encontrada");
        }
    }

    //El tipo de entrada no se puede modificar, se define el tipo de entrada en el momento de la compra
    //El precio tampoco se puede modificar porque está ligado al precio definido en el evento
    @Transactional
    public Entrada actualizar( Long id, Entrada entradaActualizada ){

        if(repositorio.existsById(id)){
            Entrada existente = repositorio.findById(id).get();

            existente.setZona(entradaActualizada.getZona());
            existente.setFechaHoraCompra(entradaActualizada.getFechaHoraCompra());
            existente.setFila(entradaActualizada.getFila());
            existente.setAsiento(entradaActualizada.getAsiento());
            existente.setValidada(entradaActualizada.isValidada());
            existente.setEspectador(entradaActualizada.getEspectador());
            existente.setEvento(entradaActualizada.getEvento());

            return repositorio.save(existente);
        }else {
            throw new RuntimeException("Entrada no encontrada");
        }
    }

    public Optional<Entrada> buscarPorId(Long id ){
        return repositorio.findById(id);
    }

    public List<Entrada> buscarPorZona(TipoZona zona ){
        return repositorio.findByZona(zona);
    }

    public List<Entrada> buscarPorTipoEntrada(TipoEntrada tipoEntrada){
        return repositorio.findByTipoEntrada(tipoEntrada);
    }

    public List<Entrada> buscarPorEspectador(Long id) {
        return repositorio.findByEspectador(id);
    }

    public List<Entrada> buscarPorEvento(Long id) {return repositorio.findByEvento(id);}

}
