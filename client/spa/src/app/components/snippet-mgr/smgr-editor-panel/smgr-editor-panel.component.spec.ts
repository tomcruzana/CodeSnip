import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmgrEditorPanelComponent } from './smgr-editor-panel.component';

describe('SmgrEditorPanelComponent', () => {
  let component: SmgrEditorPanelComponent;
  let fixture: ComponentFixture<SmgrEditorPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmgrEditorPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmgrEditorPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
