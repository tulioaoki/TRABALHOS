package model.DAO;


import java.util.List;
import connection.HibernateUtil;
import model.bean.Pessoa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class PessoaDAO {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session se = sf.getCurrentSession();
	List<Pessoa> list = null;
	
	public List<Pessoa> lp(String RG){
		Query query = se.createSQLQuery("SELECT * FROM VIEW_CIODS WHERE NUM_RG = :RG" ).setParameter("RG", RG);
		list = query.list();
	    return list;
		
		
	}
	
    public Pessoa  Busca(String RG) {
		Transaction tx = null;
		Pessoa pessoas; 
		 
		if((RG.equals("") == true) || (RG == null)) {
			throw new RuntimeException("RG não encontrado ou inexistente");
		} else {
		try{
			pessoas = new Pessoa();
			tx = se.beginTransaction();
			list = lp(RG);
			for(int i = 0; i<list.size(); i++) {
				
				pessoas.setNome(list.get(i).getNome());
				pessoas.setNome_ant(list.get(i).getNome_ant());
				pessoas.setNome_mae(list.get(i).getNome_mae());
				pessoas.setNome_pai(list.get(i).getNome_pai());
				pessoas.setSexo(list.get(i).getSexo());
				pessoas.setData_nascimento(list.get(i).getData_nascimento());
				pessoas.setData_emissao(list.get(i).getData_emissao());
				pessoas.setVia_rg(list.get(i).getVia_rg());
				pessoas.setNum_rg(list.get(i).getNum_rg());
				pessoas.setEndereco(list.get(i).getEndereco());
				pessoas.setTelefone(list.get(i).getTelefone());
				pessoas.setProfissao(list.get(i).getProfissao());
				pessoas.setEstadoCivil(list.get(i).getEstadoCivil());
				pessoas.setCic_cpf(list.get(i).getCic_cpf());
				pessoas.setNaturalidade(list.get(i).getNaturalidade());
				pessoas.setNatural_UF(list.get(i).getNatural_UF());
				pessoas.setNacionalidade(list.get(i).getNacionalidade());
				pessoas.setNome_solt(list.get(i).getNome_solt());
				
			}
			return pessoas;
		}catch(Throwable e) {
			System.out.println("Erro ao executar a Query: " + e);
			return null;
		}finally {
		    se.close();
		}
		}
        
    }
    
}
