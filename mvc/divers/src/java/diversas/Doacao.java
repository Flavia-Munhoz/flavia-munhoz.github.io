
package diversas;

public class Doacao {

	private int id_doacao;
	private String tipo_doacao;
	private String nome;
	private String email;
	private String mensagem;

	public Doacao() {
		
	}
	
	
	public Doacao(String nome, String email, String mensagem) {
		super();
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}


	public Doacao(int id_doacao, String nome, String email, String mensagem) {
		super();
		this.id_doacao = id_doacao;
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}

	public int getId_doacao() {

		return id_doacao;
	}

	public void setId_doacao(int id_doacao) {
		this.id_doacao = id_doacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getTipo_doacao() {
		return tipo_doacao;
	}


	public void setTipo_doacao(String tipo_doacao) {
		this.tipo_doacao = tipo_doacao;
	}
	
}
