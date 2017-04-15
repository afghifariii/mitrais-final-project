import { EmployeeFrontendPage } from './app.po';

describe('employee-frontend App', () => {
  let page: EmployeeFrontendPage;

  beforeEach(() => {
    page = new EmployeeFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
