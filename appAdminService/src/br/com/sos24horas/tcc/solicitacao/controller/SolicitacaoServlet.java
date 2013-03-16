package br.com.sos24horas.tcc.solicitacao.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sos24horas.service.json.DataSerializer;
import br.com.sos24horas.tcc.common.domain.Solicitacao;
import br.com.sos24horas.tcc.solicitacao.business.SolicitacaoRN;
;

@WebServlet(value = "/solicitacao")
public class SolicitacaoServlet extends HttpServlet{	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String dadosSolitacao = this.processRequest(req);
		Solicitacao solicitacao = null;
		
		try {
			if (dadosSolitacao != null && !dadosSolitacao.equals("")){
				solicitacao = DataSerializer.getInstance().toObject(dadosSolitacao, Solicitacao.class);	
			}
			
			SolicitacaoRN solic = new SolicitacaoRN();
			solic.incluirSolicitacao(solicitacao);
			System.out.println(">>>>>>>>>>>>>>>>> " + solicitacao.getLatitude());
			System.out.println(">>>>>>>>>>>>>>>>>" + solicitacao.getLongitute());
			
			String dadosRetorno = DataSerializer.getInstance().toJson(solicitacao);
			
			 
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(dadosRetorno);
			out.flush();
			
		} catch (Exception je) {
			je.printStackTrace();
			//TODO: logar aplicação
		}
		
	}
	
	/**
	 * Processa request transformando o em uma String
	 * @param req HttpServletRequest
	 * @return String
	 */
	private String processRequest(HttpServletRequest req){
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while((line = reader.readLine()) != null){
				jb.append(line);
			}
		} catch (Exception e) {
			//TODO: logar aplicação
			e.printStackTrace();
		}
		return jb.toString();
	}

}
