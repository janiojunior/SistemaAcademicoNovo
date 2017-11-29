package br.unitins.sac.report;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.unitins.sac.factory.JPAFactory;

@WebServlet("/alunoReport")
public class AlunoReportServlet extends ReportServlet {
	private static final long serialVersionUID = 4517058361373871602L;

	@Override
	public String getArquivoJasper() {
		return "AlunoReport.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("ID_CIDADE", Integer.class);
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
   
}