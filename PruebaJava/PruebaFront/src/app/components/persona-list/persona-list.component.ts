import { AfterViewInit, Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import * as Model from './../../lib/model';

@Component({
  selector: 'app-persona-list',
  templateUrl: './persona-list.component.html',
  styleUrls: ['./persona-list.component.scss']
})
export class PersonaListComponent implements OnInit,AfterViewInit {

  @Input() listaPersonas: Observable<Model.PersonaRespuestaDto[]>;
  dataSource: MatTableDataSource<
    Model.PersonaRespuestaDto
  > = new MatTableDataSource<Model.PersonaRespuestaDto>();

  displayedColumns: string[] = [
    'nombres',
    'apellidos',
    'cedula',
    'genero',
    'edad',
    'acciones',
  ];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @Output() eliminarEvent = new EventEmitter<number>();
  @Output() irActualizarEvent = new EventEmitter<{id: number, persona: Model.CrearPersonaPeticionDto }>();
  constructor() {}

  ngOnInit(): void {
    this.listaPersonas.subscribe(
      (data) =>
        (this.dataSource = new MatTableDataSource<
          Model.PersonaRespuestaDto
        >(data))
    );
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id: number){
    this.eliminarEvent.emit(id);
  }

  goActualizar(persona: Model.PersonaRespuestaDto){
    this.irActualizarEvent.emit({id: persona.id, persona: {...persona} });
  }

}
