
export class Formation {
    constructor(
        public title: string,
        public description: string,
        public price: number,
        public duration: number,
        public createdDate: Date, 
        public image: string,
        public id?: number
    ) {}
}
