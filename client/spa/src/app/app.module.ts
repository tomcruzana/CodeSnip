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
  ],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
