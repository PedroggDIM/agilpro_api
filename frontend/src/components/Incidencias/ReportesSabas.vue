<script setup>
import Navbar from "@/components/Navbar.vue"
</script>
<script>
import { mapActions, mapState } from 'pinia'
import axios from 'axios'
import { incidenciasStore } from '@/stores/incidencias.js'
import DataTable from 'datatables.net-vue3'
import DataTableLib from 'datatables.net-bs5'
import Buttons from 'datatables.net-buttons-bs5'
import ButtonsHtml5 from 'datatables.net-buttons/js/buttons.html5'
import print from 'datatables.net-buttons/js/buttons.print'
import pdfmake from 'pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import 'datatables.net-responsive-bs5';
import JsZip from 'jszip';
import Navbar from "@/components/Navbar.vue";
import moment from 'moment';

window.JsZip = JsZip;
DataTable.use(DataTableLib);
DataTable.use(pdfmake);
DataTable.use(ButtonsHtml5);

export default {
  components: { DataTable },
  props: ['incidencia'],

  data() {
    return {
      //    incidencias:null,
      columns: [
        {
          data: null,
          render: function (data, type, row, meta) {
            return ``
          }
        },
        { data: 'id' },
        { data: 'comunicaEmpresa', render: this.formatDate },
        { data: 'fechaInicio', render: this.formatDate },
        { data: 'fechaFin', render: this.formatDate },
        { data: 'numDias' },
        { data: 'estado' },
        { data: 'categoria' },
        { data: 'descripcion' },
        { data: 'infoAdicio_grabador' },
        { data: 'unidad' },
        { data: 'zona' },
      ],
    };
  },
  created() {
    debugger;
    this.getIncidencias();
  },
  computed: {
    ...mapState(incidenciasStore, ['getIncidencias', 'incidencias']),
  },
  methods: {
    editarIncidencia(id) {
      debugger;
      console.log(`Editar incidencia con ID: ${id}`);
    },
    formatDate(date) {
      if (date) {
        return moment(date).format("DD-MM-YYYY"); // Formatea la fecha si no es null
      } else {
        return "No finalizada"; // Muestra "No finalizada" si la fecha es null
      }
    },
  },
}

</script>

<template>
  <div>
    <Navbar />
  </div>
  <h3 class="titulo">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspInformes</h3>
  <!-- <h5>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Gestión y reportes de incidencias</h5> -->
  <div class="row">
    <div class="ancho">
      <div class="table-responsive">
        <DataTable :data="incidencias" :columns="columns" class="table table-striped table-bordred display" :options="{
          responsive: true, autoWidth: false, dom: 'Bfrtip', language: {
            search: 'Buscar', zeroRecords: 'No hay registros para mostrar',
            info: 'Mostrando del _START_a_END_de_TOTAL_registros',
            infoFiltered: '(Filtrados de _MAX_registros.)',
            paginate: { first: 'Primero', previous: 'Anterior', next: 'Siguiente', last: 'Último' }
          }
        }">
          <thead>
            <tr>
              <th></th>
              <th>Nº</th>
              <th>Conocimiento Empresa (dd/mm/aaaa)</th>
              <th>Fecha de inicio</th>
              <th>Fecha de finalización</th>
              <th>Días</th>
              <th>Estado</th>

              <th>Categoria</th>
              <th>Descripción</th>
              <th>Actualizaciones</th>
              <th>Unidad</th>
              <th>Zona</th>
            </tr>
          </thead>
        </DataTable>
      </div>
    </div>
  </div>
</template>
<style>
.ancho {
  width: 95%;
  margin: 0 auto;
  background-color: #E6E6E6;
  padding: 20px;
  border: 4px;
  border-radius: 10px;
}

.mb-0 {
  margin: 5px;
}

.titulo {
  font-family: 'Times New Roman';
  margin-left: 20px;
  margin-top: 20px;

}
</style>
