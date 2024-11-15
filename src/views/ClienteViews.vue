<template>
  <div class="clientes">
    <div class="components">
      <FormularioCliente @actualizar-tabla="ActualizarTabla" />
      <TablaCliente ref="TablaClientes" />
    </div>
  </div>
</template>
<script>
import FormularioCliente from "@/components/FormularioCliente.vue";
import TablaCliente from "@/components/TablaCliente.vue";

export default {
  name: "ClienteViews",

  components: {
    FormularioCliente,
    TablaCliente,
  },
  methods: {
    ActualizarTabla() {
      this.$refs.TablaClientes.obtenerClientes();
    },
  },
};
</script>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: aliceblue;
  margin: 0;
  padding: 0;
}

.components {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  gap: 18px;
}

.container-form {
  width: 23%;
  background-color: azure;
  box-shadow: 0 0 10px black;
  border-radius: 5px;
}
.container-table {
  width: 77%;
  background-color: azure;
  box-shadow: 0 0 10px black;
  border-radius: 5px;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

form {
  padding: 2%;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input {
  width: 90%;
  padding: 8px;
  border: 1px solid antiquewhite;
  border-radius: 3px;
}

select {
  width: 100%;
  padding: 8px;
  border: 1px solid antiquewhite;
  border-radius: 3px;
}

button {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: rgb(30, 130, 96);
  color: rgb(253, 236, 212);
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: blue;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

th,
td {
  padding: 10px;
  text-align: left;
  border-style: solid;
}

tr {
  border-style: solid;
}

th {
  background-color: rgb(30, 130, 96);
  color: white;
  border-style: solid;
}

tr:hover {
  background-color: blanchedalmond;
}
</style>