import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmgrCollectionsPanelComponent } from './smgr-collections-panel.component';

describe('SmgrCollectionsPanelComponent', () => {
  let component: SmgrCollectionsPanelComponent;
  let fixture: ComponentFixture<SmgrCollectionsPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SmgrCollectionsPanelComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(SmgrCollectionsPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
