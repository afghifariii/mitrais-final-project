import { Component, OnInit } from '@angular/core';

import { MdDialog, MdDialogRef } from '@angular/material';

@Component({
  selector: 'app-employee-confirm',
  templateUrl: './employee-confirm.component.html',
  styleUrls: ['./employee-confirm.component.css']
})
export class EmployeeConfirmComponent implements OnInit {

  constructor(public dialogRef: MdDialogRef<EmployeeConfirmComponent>) { }

  ngOnInit() {
  }
  

}
