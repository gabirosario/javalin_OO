package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.models.Gerenciador;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(8181);

        Gerenciador gerenciador = new Gerenciador();
        IndexController indexController = new IndexController();
        CadastroController cadastroController = new CadastroController(gerenciador);

        
        app.get("/", indexController::get);
        app.get("/teste", ctx->{ctx.result(" Teste");});

        app.get("/usuarios/cadastro", cadastroController::get);

        app.post("/usuarios/cadastro", cadastroController::post); 
        
    }
}
