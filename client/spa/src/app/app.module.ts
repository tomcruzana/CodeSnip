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
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/documentation/sidebar/sidebar.component';
import { DocumentComponent } from './components/documentation/document/document.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { LoginComponent } from './components/login/login.component';
import { SnippetMgrComponent } from './components/snippet-mgr/snippet-mgr.component';
import { SmgrSidebarComponent } from './components/snippet-mgr/smgr-sidebar/smgr-sidebar.component';
import { SmgrCategoryPanelComponent } from './components/snippet-mgr/smgr-category-panel/smgr-category-panel.component';
import { NgxCodejarModule } from 'ngx-codejar';
import { SmgrEditorPanelComponent } from './components/snippet-mgr/smgr-editor-panel/smgr-editor-panel.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { ShareComponent } from './components/share/share.component';
import { EditprofileFormComponent } from './components/profile/editprofile-form/editprofile-form.component';
import { ChangeplanFormComponent } from './components/profile/changeplan-form/changeplan-form.component';
import { ChangepaymentFormComponent } from './components/profile/changepayment-form/changepayment-form.component';
import { ScrollToTopComponent } from './components/scroll-to-top/scroll-to-top.component';
import { TagsComponent } from './components/snippet-mgr/smgr-sidebar/tags/tags.component';
import { SharedComponent } from './components/snippet-mgr/smgr-sidebar/shared/shared.component';
import { SnippetMgrSettingsComponent } from './components/snippet-mgr/smgr-sidebar/snippet-mgr-settings/snippet-mgr-settings.component';
import {
  HttpClientModule,
  HttpClientXsrfModule,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { UserAuthGuard } from './routeguards/userauth.guard';
import { AjaxhttpInterceptor } from './interceptors/ajaxhttpinterceptor';
import { AppRoutingModule } from './app-routing.module';

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
    LoginComponent,
    SnippetMgrComponent,
    SmgrSidebarComponent,
    SmgrCategoryPanelComponent,
    SmgrEditorPanelComponent,
    RegisterComponent,
    ProfileComponent,
    ShareComponent,
    EditprofileFormComponent,
    ChangeplanFormComponent,
    ChangepaymentFormComponent,
    ScrollToTopComponent,
    TagsComponent,
    SharedComponent,
    SnippetMgrSettingsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgxCodejarModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),
    AppRoutingModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AjaxhttpInterceptor,
      multi: true,
    },
    UserAuthGuard,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
