import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ConfigComponent } from './config/config.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, ConfigComponent],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'frontend';
}
