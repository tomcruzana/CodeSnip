import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeplanFormComponent } from './changeplan-form.component';

describe('ChangeplanFormComponent', () => {
  let component: ChangeplanFormComponent;
  let fixture: ComponentFixture<ChangeplanFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeplanFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangeplanFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
