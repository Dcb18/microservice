package br.com.dcb.product.exception.details;

import lombok.Getter;

@Getter
public class ValidationErroDetails extends ErroDetails {

    private String fildes;
    private String fildesMessage;


    public static final class Builder {
        private String titulo;
        private  int status;
        private String menssage;
        private long time;
        private String resumo;
        private String fildes;
        private String fildesMessage;

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

        public Builder fildes(String fildes) {
            this.fildes = fildes;
            return this;
        }

        public Builder fildesMessage(String fildesMessage) {
            this.fildesMessage = fildesMessage;
            return this;
        }

        public ErroDetails build() {
            ValidationErroDetails validationErroDetails = new ValidationErroDetails();
            validationErroDetails.titulo = this.titulo;
            validationErroDetails.resumo = this.resumo;
            validationErroDetails.status = this.status;
            validationErroDetails.time = this.time;
            validationErroDetails.menssage = this.menssage;
            validationErroDetails.fildes = this.fildes;
            validationErroDetails.fildesMessage = this.fildesMessage;



            return validationErroDetails;
        }
    }

}
