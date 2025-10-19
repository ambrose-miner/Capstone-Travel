import { Component } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
logout():void{//logout function
  sessionStorage.clear();
  this.RouterOutlet.navigate(["/login"]);//not RouterOutlet...?
  //not router or Router
}
}
