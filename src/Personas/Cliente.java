package Personas;

public class Cliente {
	private String id;

  private String nome;
  private String cpf;
  private String rg;
  private String dtNasc;
  private String sexo;
  private String endereco;
  private String bairro;
  private String municipio;
  private String uf;
  private String email;
  private String senha;

	private boolean registered;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getRg() {
    return this.rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getDtNasc() {
    return this.dtNasc;
  }

  public void setDtNasc(String dtNasc) {
    this.dtNasc = dtNasc;
  }

  public String getSexo() {
    return this.sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getMunicipio() {
    return this.municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public String getUf() {
    return this.uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean getRegistered() {
    return this.registered;
  }

  public void setRegistered(boolean registered) {
    this.registered = registered;
  }

  protected Cliente() {
  }

  public Cliente(

    String nome,
    String cpf,
    String rg,
    String dtNasc,
    String sexo,
    String endereco,
    String bairro,
    String municipio,
    String uf,
    String email,
    String senha,
    boolean registered
  )
  {
    this.setNome(nome);
    this.setCpf(cpf);
    this.setRg(rg);
    this.setDtNasc(dtNasc);
    this.setSexo(sexo);
    this.setEndereco(endereco);
    this.setBairro(bairro);
    this.setMunicipio(municipio);
    this.setUf(uf);
    this.setEmail(email);
    this.setSenha(senha);
    this.setRegistered(registered);
  }

  public Cliente(String[] values, boolean isRegistered) throws Exception{
    this.setNome(values[0]);
    this.setCpf(values[1]);
    this.setRg(values[2]);
    this.setDtNasc(values[3]);
    this.setSexo(values[4]);
    this.setEndereco(values[5]);
    this.setBairro(values[6]);
    this.setMunicipio(values[7]);
    this.setUf(values[8]);
    this.setEmail(values[9]);
    this.setSenha(values[10]);
    this.setRegistered(isRegistered);
  }

}
