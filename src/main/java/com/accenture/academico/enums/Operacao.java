package com.accenture.academico.enums;


public enum Operacao {

	SAQUE(1, "Saque"),
	DEPOSITO (2, "Deposito"),
    TRANSFERENCIAENVIADA(3, "Transferencia Enviada"),
    TRANSFERENCIARECEBIDA(4, "Transferencia Recebida");
    
    private int cod;
    private String descricao;
    
    private Operacao(int cod, String descricao) {
    	this.cod = cod;
    	this.descricao = descricao;
    }
    
    public int getCod() {
    	return cod;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    
    public static Operacao toEnum(Integer cod) {
    	
    	if (cod == null) {
    		return null;
    	}
    	
    	for (Operacao x : Operacao.values()) {
    		if (cod.equals(x.getCod())) {
    			return x;
    		}
    	}
    	
    	throw new IllegalArgumentException("Código inválido");
    }
	
}
