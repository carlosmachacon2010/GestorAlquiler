<template>
    <div class="container-table">
        <h1>Tabla de Clientes</h1>
        <table>
            <thead>
                <tr>
                    <th>Identificacion</th>
                    <th>Nacionalidad</th>
                    <th>Indicador</th>
                    <th>Numero_Celular</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>correo electronico</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="cliente in clientes" :key="cliente.identificacion">
                    <td>{{cliente.identificacion}}</td>
                    <td>{{cliente.nacionalidad}}</td>
                    <td>{{cliente.indicador}}</td>
                    <td>{{cliente.numero_celular}}</td>
                    <td>{{cliente.nombres}}</td>
                    <td>{{cliente.apellidos}}</td>
                    <td>{{cliente.correo_electronico}}</td>
                </tr>
             
            </tbody>
        </table>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data(){
            return{
                clientes:[],
            };
        },
        methods:{
            obtenerClientes(){
                axios.get("http://localhost:8080/api/clientes/listar")
                .then((Response)=>{
                    this.clientes=Response.data;
                })
                .catch((error)=>{
                    console.error("Error al traer la lista de cliente",error);
                });
            },
        },
        mounted(){
            this.obtenerClientes();
        },
    };
</script>