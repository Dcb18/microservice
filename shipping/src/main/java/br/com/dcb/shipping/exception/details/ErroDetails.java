package br.com.dcb.shipping.exception.details;


import lombok.Getter;

@Getter
public class ErroDetails {

    protected String titulo;
    protected  int status;
    protected String menssage;
    protected long time;
    protected String resumo;


    public static final class Builder {
        private String titulo;
        private  int status;
        private String menssage;
        private long time;
        private String resumo;

        private Builder() {
        }

        public static Builder newErro() {
            return new Builder();
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder menssage(String menssage) {
            this.menssage = menssage;
            return this;
        }

        public Builder time(long time) {
            this.time = time;
            return this;
        }

        public Builder resumo(String resumo) {
            this.resumo = resumo;
            return this;
        }

        public ErroDetails build() {
            ErroDetails erroDetails = new ErroDetails();
            erroDetails.titulo = this.titulo;
            erroDetails.resumo = this.resumo;
            erroDetails.status = this.status;
            erroDetails.time = this.time;
            erroDetails.menssage = this.menssage;
            return erroDetails;
        }
    }
}
