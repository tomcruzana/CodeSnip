import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SnippetMgrSettingsComponent } from './snippet-mgr-settings.component';

describe('SnippetMgrSettingsComponent', () => {
  let component: SnippetMgrSettingsComponent;
  let fixture: ComponentFixture<SnippetMgrSettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SnippetMgrSettingsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SnippetMgrSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
