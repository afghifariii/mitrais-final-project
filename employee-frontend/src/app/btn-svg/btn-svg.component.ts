import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { MdIconRegistry } from '@angular/material';

@Component({
  selector: 'btn-svg',
  template: ''
})

export class BtnSvgComponent {
  constructor(iconRegistry: MdIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'add',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/add.svg'));
    iconRegistry.addSvgIcon(
      'menu',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/menu.svg'));
    iconRegistry.addSvgIcon(
      'settings',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/settings.svg'));
    iconRegistry.addSvgIcon(
      'power_settings_new',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/power_settings_new.svg'));
    iconRegistry.addSvgIcon(
      'sort_by_alpha',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/sort_by_alpha.svg'));
    iconRegistry.addSvgIcon(
      'search',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/search.svg'));
    iconRegistry.addSvgIcon(
      'filter_list',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/filter_list.svg'));
    iconRegistry.addSvgIcon(
      'restore',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/restore.svg'));
    iconRegistry.addSvgIcon(
      'person',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/person.svg'));
    iconRegistry.addSvgIcon(
      'people',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/people.svg'));
    iconRegistry.addSvgIcon(
      'location',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/location.svg'));
    iconRegistry.addSvgIcon(
      'layers',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/layers.svg'));
    iconRegistry.addSvgIcon(
      'home',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/home.svg'));
    iconRegistry.addSvgIcon(
      'radio_button_checked',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/radio_button_checked.svg'));
    iconRegistry.addSvgIcon(
      'chevron_right',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/chevron_right.svg'));
      iconRegistry.addSvgIcon(
        'sort-asc',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/sort-asc.svg'));
    iconRegistry.addSvgIcon(
        'sort-desc',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/sort-desc.svg'));
    iconRegistry.addSvgIcon(
        'delete',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/delete.svg'));
    iconRegistry.addSvgIcon(
        'filter',
      sanitizer.bypassSecurityTrustResourceUrl('src/resources/svg/filter.svg'));
  }
}