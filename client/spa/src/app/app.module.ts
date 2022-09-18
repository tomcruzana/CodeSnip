import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { JumbotronComponent } from './components/jumbotron/jumbotron.component';
import { FeaturesComponent } from './components/features/features.component';
import { FooterComponent } from './components/footer/footer.component';
import { ThemeSwitcherComponent } from './components/theme-switcher/theme-switcher.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DocumentationComponent } from './components/documentation/documentation.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/documentation/sidebar/sidebar.component';
import { DocumentComponent } from './components/documentation/document/document.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    JumbotronComponent,
    FeaturesComponent,
    FooterComponent,
    ThemeSwitcherComponent,
    NotFoundComponent,
    DocumentationComponent,
    PricingComponent,
    HomeComponent,
    SidebarComponent,
    DocumentComponent,
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    RouterModule.forRoot([
      { path: 'home', component: HomeComponent },
      { path: 'documentation', component: DocumentationComponent },
      { path: 'pricing', component: PricingComponent },
      { path: 'login', component: PricingComponent },
      { path: '', redirectTo: '/home', pathMatch: 'full' },
      { path: '**', component: NotFoundComponent },
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
