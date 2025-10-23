package main.crud;

import java.util.ArrayList;

import main.models.Categoria;
import main.utils.ConsolaUtils;

public class CategoriaCrud extends ConsolaCrud<Categoria> {

    private final ArrayList<Categoria> categorias;
    public CategoriaCrud(ArrayList<Categoria> listaCat){
        this.categorias = listaCat;
    }
    
    @Override
    public void crear() {
        ConsolaUtils.limpiarConsola();
        categorias.add(new Categoria(leerTexto("Ingrese el nombre de la categoria:\n")));
        System.out.println("Categoria creada exitosamente...");
    }

    @Override
    public void listar() {
        ConsolaUtils.limpiarConsola();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias actualmente...");
        } else {
            categorias.forEach(System.out::println);
        }
        
    }

    @Override
    public void actualizar() {
        ConsolaUtils.limpiarConsola();
        listar();
        int id = leerEntero("Ingrese el id de la categoria a modificar nombre:\n");
        for (Categoria categoria : categorias) {
            if(categoria.getId() == id){
                ConsolaUtils.limpiarConsola();
                categoria.setNombre(
                    leerTexto("Ingrese un nombre nuevo a la categoria '" + categoria.getNombre() + "':\n"));
                ConsolaUtils.limpiarConsola();
                System.out.println("Categoria actualizada:\n " + categoria);
                return;
            }
        }
        ConsolaUtils.limpiarConsola();
        System.out.println("No se encontro una categoria con id '" + id +"'...");
    }

    @Override
    public void eliminar() {
        ConsolaUtils.limpiarConsola();
        listar();
        int id = leerEntero("Id de la categoría a eliminar:\n");
        boolean eliminado = categorias.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "Categoria eliminada...": "No existe ese id...");
    }

}
