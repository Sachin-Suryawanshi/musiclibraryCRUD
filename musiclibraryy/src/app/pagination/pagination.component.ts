import { Component, OnInit } from '@angular/core';
import { MusiclibraryService } from '../services/musiclibrary.service';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  constructor(private musiclibraryService:MusiclibraryService) { }
  page=0;
  perPage=0;
  totalData=0;
  totalPage=0;
  content:any;
  musiclibrary:any;
  ngOnInit(): void {
    this.pagination();
  }
  public pagination()
  {
    this.musiclibraryService.pagination(this.page).subscribe((data)=>
    {
      this.content=data;
      this.musiclibrary=this.content.content;
      this.perPage=this.content.pageSize;
      this.totalData=this.content.totalElements;
      this.totalPage=this.content.totalPages;

    });
  }
  doInfinite()
  {
    console.log("scrolled");
    this.page=this.page+1;
    setTimeout(()=>
    {
      this.musiclibraryService.pagination(this.page).subscribe(resp=>
        {
          this.content=resp;
          //this.musiclibrary=this.content.content;
          this.perPage=this.content.pageSize;
          this.totalData=this.content.totalElements;
          this.totalPage=this.content.totalPages;
          for(let i=0;i<this.content.content.length;i++)
          {
            this.musiclibrary.push(this.content.content[i]);
          }

        });
        console.log("Async operation has ended");
        //infiniteScroll.complete();
    },1000);

  }

}
