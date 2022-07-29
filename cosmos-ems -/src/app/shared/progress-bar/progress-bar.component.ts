import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'em-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css'],
})
export class ProgressBarComponent implements OnInit {
  constructor() {}

  color: string = '';
  @Input() progress: number = 0;
  @Input() firstName:string='';
  @Output() progressClick: EventEmitter <string>=new EventEmitter<string>;

  ngOnInit(): void {
    if (this.progress < 35) {
      this.color = 'bg-danger';
    } else if (this.progress < 75) {
      this.color = 'bg-warning';
    } else {
      this.color = 'bg-success';
    }

    if (this.progress < 0 || this.progress > 100) {
      this.progress = 0;
    }



  }
  onClick(){
    this.progressClick.emit(` ${this.firstName}'s Progress is ${this.progress} %`)
  }
}
