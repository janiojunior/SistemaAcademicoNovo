package br.unitins.sac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

	private static final String url = "jdbc:postgresql://localhost:5432/web2";
	private static final String driver = "org.postgresql.Driver";
	private static final String login = "postgres";
	private static final String pwd = "123456";

	public void gerar(String layout) throws JRException, SQLException, ClassNotFoundException {
		// gerando o jasper design
		JasperDesign desenho = JRXmlLoader.load(layout);

		// compila o relat�rio
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		// estabelece conex�o
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, login, pwd);
		Statement stm = con.createStatement();
		String query = "SELECT    a.matricula,   a.nome,   c.nome as nomeCidade,   a.dataNascimento  FROM    public.aluno a,    public.cidade c WHERE   a.idCidade = c.id";
		ResultSet rs = stm.executeQuery(query);

		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

		// executa o relat�rio
		Map parametros = new HashMap();
		parametros.put("nota", new Double(10));
		JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

		// exibe o resultado
		JasperViewer viewer = new JasperViewer(impressao, true);
		viewer.show();
	}

	public static void main(String[] args) {
		try {
			new Report().gerar("reports/AlunoReport.jrxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}