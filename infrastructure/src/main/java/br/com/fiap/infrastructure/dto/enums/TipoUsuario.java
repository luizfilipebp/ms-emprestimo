package br.com.fiap.infrastructure.dto.enums;

public enum TipoUsuario {
    ADMIN("ADM", "Administrador"),
    ALUNO("ALN", "Aluno"),
    MEMBRO("MEM", "Membro"),
    PROFESSOR("PRO", "Professor"),
    FUNCIONARIO("FUN", "Funcionário");

    TipoUsuario(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    private final String id;
    private final String descricao;

    public static TipoUsuario fromId(String id) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.name().equalsIgnoreCase(id)) {
                return tipoUsuario;
            }
        }
        return MEMBRO;
    }

    public static TipoUsuario fromString(String tipo) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.name().equalsIgnoreCase(tipo)) {
                return tipoUsuario;
            }
        }
        return MEMBRO;
    }

    public static TipoUsuario fromId(int id) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.ordinal() == id) {
                return tipoUsuario;
            }
        }
        return MEMBRO;
    }

    public static int toId(TipoUsuario tipo) {
        return tipo.ordinal();
    }
}
