import { Component } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
routerLink: any;//what is this and what is the "any"?
//line 9 was the auto generated fix for my implementation of routerLink bellow.
logout():void{//logout function
  sessionStorage.clear();
 // <a href= "http:CapstoneTravel/login"></a>
  this.routerLink.navigate(["/login"]);
}
}
