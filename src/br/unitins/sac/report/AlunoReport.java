package br.unitins.sac.report;

import org.primefaces.model.StreamedContent;

import br.unitins.sac.util.Report;

public class AlunoReport {
	private String dataSource;
	private String folder;
	private String file;
	private StreamedContent pdf;
	public AlunoReport(String dataSource, String folder, String file) {
		this.dataSource = dataSource;
		this.folder = folder;
		this.file = file;
		this.pdf = pdf;
	}
	
	public void abrirRelatorio() {
		AlunoReport report = new AlunoReport("jdbc/web2", "reports", "CidadeReport");
//		relatorio = new Report("jdbc/web2", "reports", "CidadeReport");
//		return relatorio;
	}


}
