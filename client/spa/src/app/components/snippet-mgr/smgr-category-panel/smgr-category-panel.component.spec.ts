import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmgrCategoryPanelComponent } from './smgr-category-panel.component';

describe('SmgrCategoryPanelComponent', () => {
  let component: SmgrCategoryPanelComponent;
  let fixture: ComponentFixture<SmgrCategoryPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmgrCategoryPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmgrCategoryPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
