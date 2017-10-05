public Class Administrador{
  private int id;
	private String nome;
	private String senha;
	private int nivel_id;


  public int id(){
  	return nivel_id;
  }
	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome=nome;
	}

	public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha=senha;
	}

	public int getNivel_id(){
		return nivel_id;
	}

	public void setNivel_id(int nivel_id){
		this.nivel_id=nivel_id;
	}
}
