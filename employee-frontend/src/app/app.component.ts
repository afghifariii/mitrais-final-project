import { Component } from '@angular/core';

import { trigger, state, style, animate, transition } from '@angular/animations';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    trigger('state', [
      state('in', style({
        transform: 'translate3d(0, 0, 0)'
      })),
      state('out', style({
        transform: 'translate3d(100%, 0, 0)'
      })),
      transition('in <=> out', animate('200ms ease-in-out'))
    ]),
    trigger('listState', [
      state('in', style({
        transform: 'translate3d(0, 0, 0)'
      })),
      state('out', style({
        transform: 'translate3d(-50%, 0, 0)'
      })),
      transition('in <=> out', animate('200ms ease-in-out'))
    ]),
  ]
})
export class AppComponent {
  showForm = 'out';
  formCol = 0;

  toggle() {
    this.formCol = 0;
  };

  toggleForm() {
    this.showForm = (this.showForm === 'in' ? 'out' : 'in');
  }
}