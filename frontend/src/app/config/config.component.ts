import { Component } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ConfigDTO } from '../dto/config';
import { ConfigService } from '../services/config/config.service';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-coco',
  standalone: true,
  imports: [
    MatTableModule,
    MatLabel,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
  ],
  templateUrl: './config.component.html',
})
export class ConfigComponent {
  dataSource: any[];
  newConfig: ConfigDTO;
  constructor(private configService: ConfigService) {
    this.dataSource = [];
    this.newConfig = { id: 0, key: '', value: '' };
  }
  displayedColumns: string[] = ['id', 'key', 'value', 'action'];
  ngOnInit() {
    this.loadConfig();
  }
  loadConfig() {
    console.log('getting config list.');
    this.configService.getConfigList().subscribe({
      next: (data) => {
        this.dataSource = data;
      },
      error: (error) => console.error('Error loading Config:', error),
    });
  }
  createConfig() {
    this.configService.createConfig(this.newConfig).subscribe({
      next: () => {
        this.newConfig = {
          id: 0,
          key: '',
          value: '',
        };
        this.loadConfig();
      },
      error: (error) => console.error('Error creating Config:', error),
      complete: () => {},
    });
  }

  updateConfigVal(config: ConfigDTO) {
    this.configService.updateConfig(config.id, config).subscribe(
      () => this.loadConfig(),
      (error) => console.error('Error updating Config:', error)
    );
  }
  deleteConfig(id: number) {
    this.configService.deleteConfig(id).subscribe(
      () => this.loadConfig(),
      (error) => console.error('Error deleting Config:', error)
    );
  }
}
