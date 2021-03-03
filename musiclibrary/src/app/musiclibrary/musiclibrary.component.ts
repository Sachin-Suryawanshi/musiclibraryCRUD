import { Component, OnInit } from '@angular/core';
import { MusiclibraryService } from '../services/musiclibrary.service';

@Component({
  selector: 'app-musiclibrary',
  templateUrl: './musiclibrary.component.html',
  styleUrls: ['./musiclibrary.component.css']
})
export class MusiclibraryComponent implements OnInit {

  constructor(private musiclibraryService:MusiclibraryService) { }

  ngOnInit(): void {
  }

  insertmusiclibrary(musiclibrary:any)
  {
    this.musiclibraryService.insertmusiclibrary(musiclibrary.value).subscribe((data)=>
    {
      console.log(data);
    },err=>
    {
      console.log(err);
    })
  }

}
