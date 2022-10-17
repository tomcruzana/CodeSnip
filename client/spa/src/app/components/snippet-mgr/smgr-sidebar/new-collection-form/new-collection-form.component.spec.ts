import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCollectionFormComponent } from './new-collection-form.component';

describe('NewCollectionFormComponent', () => {
  let component: NewCollectionFormComponent;
  let fixture: ComponentFixture<NewCollectionFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCollectionFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCollectionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
