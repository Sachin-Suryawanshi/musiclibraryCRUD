import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MusiclibraryService {

  constructor(private http:HttpClient) { }
  getallmusicLibrarries()
  {
    return this.http.get("http://localhost:8080/getallmusiclibrary");
  }

  getmusiclibraryById(songId:any)
  {
    return this.http.get("http://localhost:8080/getmusiclibrarybyid"+songId);
  }

 public deletemusiclibrary(songId:any)
  {
    return this.http.delete("http://localhost:8080/deletemusiclibrary/"+songId);
  }
  public updatemusiclibrary(musiclib:any)
  {
    return this.http.put("http://localhost:8080/updatemusiclibrary",musiclib);
  }
  public insertmusiclibrary(musiclibrary:any)
  {
    return this.http.post("http://localhost:8080/insertmusiclibrary",musiclibrary);
  }
}
