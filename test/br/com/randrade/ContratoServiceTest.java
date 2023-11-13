package br.com.randrade;

import br.com.randrade.dao.ContratoDao;
import br.com.randrade.dao.IContratoDao;
import br.com.randrade.mock.ContratoDaoMock;
import br.com.randrade.service.ContratoService;
import br.com.randrade.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retornoSalvar = service.salvar();
        String retornoBuscar = service.buscar();
        String retornoExcluir = service.excluir();
        String retornoAtualizar = service.atualizar();
        Assert.assertEquals("Sucesso", retornoSalvar);
        Assert.assertEquals("Sucesso", retornoBuscar);
        Assert.assertEquals("Sucesso", retornoExcluir);
        Assert.assertEquals("Sucesso", retornoAtualizar);
    }
    @Test (expected = UnsupportedOperationException.class)
    public void esperadoErroAoSalvarBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retornoSalvar = service.salvar();
        String retornoBuscar = service.buscar();
        String retornoExcluir = service.excluir();
        String retornoAtualizar = service.atualizar();
        Assert.assertEquals("Sucesso", retornoSalvar);
        Assert.assertEquals("Sucesso", retornoBuscar);
        Assert.assertEquals("Sucesso", retornoExcluir);
        Assert.assertEquals("Sucesso", retornoAtualizar);
    }

}