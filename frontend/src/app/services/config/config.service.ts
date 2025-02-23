import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConfigDTO } from '../../dto/config';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private apiUrl = environment.apiUrl + '/api/config';

  constructor(private http: HttpClient) {}

  getConfigList(): Observable<ConfigDTO[]> {
    var res = this.http.get<ConfigDTO[]>(this.apiUrl);
    return res;
  }

  getConfig(id: number): Observable<ConfigDTO> {
    return this.http.get<ConfigDTO>(`${this.apiUrl}/${id}`);
  }

  createConfig(config: ConfigDTO): Observable<ConfigDTO> {
    return this.http.post<ConfigDTO>(this.apiUrl, config);
  }

  updateConfig(id: number, config: ConfigDTO): Observable<ConfigDTO> {
    return this.http.put<ConfigDTO>(`${this.apiUrl}/${id}`, config);
  }

  deleteConfig(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  searchByKeyword(key: string): Observable<ConfigDTO[]> {
    return this.http.get<ConfigDTO[]>(`${this.apiUrl}/search?key=${key}`);
  }
}
