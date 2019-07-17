package model.DAO;

import javax.jws.WebService;

import model.bean.Pessoa;

import javax.jws.WebMethod;
import javax.jws.WebParam;





@WebService(serviceName = "PesquisaRG")
public class PesquisaRG {
	 @WebMethod(operationName = "busca_RG")
	    public Pessoa busca_RG(@WebParam(name = "RG") String RG) {
	        PessoaDAO pessoa = new PessoaDAO();
	        return pessoa.Busca(RG);
	    }
}
