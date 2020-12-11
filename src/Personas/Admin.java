package Personas;

public class Admin extends Cliente {

	private boolean isAdmin = false;

	public Admin(
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
		boolean isAdmin
	) {
		super(
			nome,
			cpf,
			rg,
			dtNasc,
			sexo,
			endereco,
			bairro,
			municipio,
			uf,
			email,
			senha,
			true
		);
		this.setIsAdmin(isAdmin);
	}

	public Admin(String id, String nome, String cpf, boolean isAdmin) {
		super(nome, cpf, "", "", "", "", "", "", "", "", "", true);
		this.setIsAdmin(isAdmin);
		super.setId(id);
	}

	public Admin(String[] values, boolean isAdmin) throws Exception {
		super(values, true);
		this.setIsAdmin(isAdmin);
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}
}
