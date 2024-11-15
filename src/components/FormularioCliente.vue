<template>
  <div class="container-form">
    <h2>Formulario Cliente</h2>
    <form id="cliente-form" @submit.prevent="guardar">
      <div class="form-group">
        <label for="codigo">Identificacion:</label>
        <input
          type="number"
          id="codigo"
          name="identificacion"
          required
          v-model="identificacion"
        />
      </div>
      <div class="form-group">
        <label for="nacionalidad_cliente">Nacionalidad</label>

        <select v-model="selectedValue" @change="updateInputs">
          <option disabled value="">Selecciona una opción</option>
          <option value="+57">Colombiano</option>
          <option value="+52">Méxicano</option>
          <option value="+54">Argentino</option>
          <option value="+34">Español</option>
          <option value="+1">Estados Unidence</option>
        </select>
      </div>
      <div class="form-group">
        <label for="indicativolinea">Indicativo:</label>
        <input
          type="text"
          id="indicativolinea"
          required
          v-model="indicativolinea"
          readonly
        />
      </div>

      <div class="form-group">
        <label for="telefonico">Numero Telefonco:</label>
        <input
          type="number"
          id="telefonico"
          name="numero_celular"
          required
          v-model="numero_celular"
        />
      </div>

      <div class="form-group">
        <label for="nombre">Nombres:</label>
        <input
          type="text"
          id="nombre"
          name="nombres"
          required
          v-model="nombres"
        />
      </div>
      <div class="form-group">
        <label for="apellidos">Apellidos:</label>
        <input
          type="text"
          id="apellidos"
          name="apellidos"
          required
          v-model="apellidos"
        />
      </div>
      <div class="form-group">
        <label for="cliente_email">Correo Electronico:</label>
        <input
          type="email"
          id="cliente_email"
          name="correo_electronico"
          required
          v-model="correo_electronico"
        />
      </div>

      <input type="hidden" v-model="nacionalidad" />

      <Button type="submit" id="guardar" name="guardar">Guardar</Button><br />
      <Button type="button" id="eliminar" name="eliminar" @click="eliminar"
        >Eliminar</Button
      ><br />
      <Button
        type="button"
        id="actualizar"
        name="actualizar"
        @click="actualizar"
        >Actualizar</Button
      ><br />
      <Button type="button" id="consultar" name="consultar" @click="consultar"
        >Consultar</Button
      ><br />
      <Button type="button" id="limpiar" name="limpiar" @click="limpiar"
        >Limpiar</Button
      >
    </form>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      selectedValue: "", //selectedValue: "", // Para almacenar el país seleccionado
      identificacion: "",
      nacionalidad: "", //para mostrar la nacionalidad en el input de nacionalidades
      numero_celular: "",
      nombres: "",
      apellidos: "",
      correo_electronico: "",
      indicador: "",
    };
  },
  methods: {
    // Método para asignar el indicativo cuando cambie la selección
    updateInputs() {
      this.nacionalidad = this.getSelectedText();
      this.indicativolinea = this.selectedValue;
    },
    getSelectedText() {
      const selectElement = this.$el.querySelector("select");
      return selectElement.options[selectElement.selectedIndex].text;
    },

    guardar() {
      axios
        .post("http://localhost:8080/api/clientes", {
          identificacion: this.identificacion,
          apellidos: this.apellidos,
          correo_electronico: this.correo_electronico,
          indicador: this.indicativolinea,
          nacionalidad: this.nacionalidad,
          nombres: this.nombres,
          numero_celular: this.numero_celular,
        })

        .then((Response) => {
          console.log("Huesped Registrado con exitos", Response.data);
          alert("Cliente Registrado con exito: ");
          this.identificacion = "";
          this.apellidos = "";
          this.correo_electronico = "";
          this.indicativolinea = "";
          this.nacionalidad = "";
          this.nombres = "";
          this.numero_celular = "";
          this.$emit("actualizar-tabla");
        })

        .catch((error) => {
          console.error("Error al registrar al cliente", error);
        });
    },
    consultar() {
      axios
        .get("http://localhost:8080/api/clientes/" + this.identificacion)
        .then((Response) => {
          this.apellidos = Response.data.apellidos;
          this.nombres = Response.data.nombres;
          this.indicativolinea = Response.data.indicador;
          this.correo_electronico = Response.data.correo_electronico;
          this.selectedValue = Response.data.nacionalidad;
          this.numero_celular = Response.data.numero_celular;
        })
        .catch((error) => {
          console.log("Error al consultar un cliente", error);
        });
    },
    actualizar() {
      axios
        .put(
          "http://localhost:8080/api/clientes/actualizar/" +
            this.identificacion,
          {
            identificacion: this.identificacion,
            apellidos: this.apellidos,
            correo_electronico: this.correo_electronico,
            indicador: this.indicativolinea,
            nacionalidad: this.nacionalidad,
            nombres: this.nombres,
            numero_celular: this.numero_celular,
          }
        )
        .then((Response) => {
          alert("Datos Actualizado con Exito");
          console.log("Cliente Actulizado con exito", Response.data);
          this.identificacion = "";
          this.nombres = "";
          this.correo_electronico = "";
          this.apellidos = "";
          this.indicativolinea = "";
          this.numero_celular = "";
          this.$emit("actualizar-tabla");
        })
        .catch((error) => {
          console.error("Error al actualizar el cliente", error);
        });
    },
    eliminar() {
      axios
        .delete("http://localhost:8080/api/clientes/" + this.identificacion)
        .then(() => {
          console.log("Cliente eliminado con exito");
          alert("Cliente eliminado con exito");
          this.identificacion = "";
          this.nombres = "";
          this.correo_electronico = "";
          this.apellidos = "";
          this.indicativolinea = "";
          this.numero_celular = "";
          this.$emit("actualizar-tabla");
        })
        .catch((error) => {
          console.error("Fallo al eliminar eliminar el cliente", error);
        });
    },

    limpiar() {
      this.identificacion = "";
      this.nombres = "";
      this.correo_electronico = "";
      this.apellidos = "";
      this.indicativolinea = "";
      this.numero_celular = "";
    },
  },
};
</script>