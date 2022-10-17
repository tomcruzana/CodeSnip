import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmgrSettingsComponent } from './smgr-settings.component';

describe('SmgrSettingsComponent', () => {
  let component: SmgrSettingsComponent;
  let fixture: ComponentFixture<SmgrSettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmgrSettingsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmgrSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
