import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, withHashLocation, RouterModule } from '@angular/router';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppModule } from './app.module';
@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  //imports: [RouterOutlet,RouterLink,RouterModule,AppModule],
  //this seems to be the problem right here^^
})
export class AppComponent {}
  


  // logout():string{//logout function
  // sessionStorage.clear();
  // return this.routerLink.navigate(["/login"]);
//}

