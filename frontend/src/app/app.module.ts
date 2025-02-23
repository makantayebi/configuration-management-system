import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ConfigComponent } from './config/config.component';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { routes } from './app.routes';

@NgModule({
  declarations: [AppComponent, ConfigComponent],
  imports: [BrowserModule, RouterModule.forRoot(routes)],
  bootstrap: [AppComponent],
})
export class AppModule {}
