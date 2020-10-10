package com.example.project;

public class Loja {

    private static final String ENDLN = System.lineSeparator();
	private static boolean isEmpty(String str){
		if(str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
		return (spaceCount == str.length());
	}

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, Endereco endereco, String telefone,
                String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String dadosLoja() {
        // Implemente aqui
        
        String num = this.getEndereco().getNumero() + "";

		if (isEmpty(this.getNomeLoja())){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}
		if(isEmpty (this.getEndereco().getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}
		if(this.getEndereco().getNumero() == 0){
			num = "s/n";
		}
		if(isEmpty(this.getEndereco().getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		if (isEmpty(this.getEndereco().getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}
		if (isEmpty(this.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}
		if (isEmpty(this.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}
		String part2 = this.getEndereco().getLogradouro()+ ", " + num;
		if (! isEmpty (this.getEndereco().getComplemento())){
			part2 += " " + this.getEndereco().getComplemento();
			}
		String part3 = "";
		if (! isEmpty (this.getEndereco().getBairro())){
			part3 += this.getEndereco().getBairro() + " - ";
		}
		part3 += this.getEndereco().getMunicipio() +  " - " + this.getEndereco().getEstado();
		
		String part4 = "";
		if (! isEmpty (this.getEndereco().getCep())){
			part4 = "CEP:" + this.getEndereco().getCep();
			}
		if (! isEmpty (this.getTelefone())){
			if (! isEmpty (part4)){
				part4 += " ";
			}
			part4 += "Tel " + this.getTelefone();
			}
		if (! isEmpty(part4)){
			part4 += ENDLN;
			}
		String part5 = "";
		if (! isEmpty (this.getObservacao())){
			part5 += this.getObservacao();
			}

		String output = this.getNomeLoja() + ENDLN;
		output += part2 + ENDLN;
		output += part3 + ENDLN;
		output += part4;
		output += part5 + ENDLN;
		output += "CNPJ: " + this.getCnpj() + ENDLN;
        output += "IE: " + this.getInscricaoEstadual() +ENDLN;
		return output;
	}

}