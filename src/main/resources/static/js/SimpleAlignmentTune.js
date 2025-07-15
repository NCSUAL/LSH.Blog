/**
 * block-wise alignment tune
 * 저장 형식 : { alignment: 'left' | 'center' | 'right' | 'justify' }
 */
class SimpleAlignmentTune {
    /**
     * @param {{api: any, data: any, block: any}} param0
     */
    constructor({ api, data, block }) {
      this.api     = api;
      this.block   = block;                 // 현재 블록 인스턴스
      this.data    = data || { alignment:'left' };
      this.wrapper = undefined;             // 버튼 그룹 DOM
      this.buttons = ['left','center','right','justify']
        .map(dir => this._createButton(dir));
    }
  
    /** Editor.js가 버튼을 렌더링할 때 호출 */
    render() {
      this.wrapper = document.createElement('div');
      this.wrapper.classList.add('cdx-simple-align');
      this.buttons.forEach(b => this.wrapper.appendChild(b));
      this._applyAlignment();               // 최초 상태 반영
      return this.wrapper;
    }
  
    /** 저장할 데이터 반환 */
    save() {
      return this.data;
    }
  
    /** 특수 키 (툴바 위치) */
    static get isTune() { return true; }
  
    /** 내부 ― 버튼 하나 생성 */
    _createButton(dir) {
      const button = document.createElement('div');
      button.className = 'cdx-align-btn';
      button.innerHTML = dir.slice(0,1).toUpperCase(); // L / C / R / J
      button.dataset.dir = dir;
  
      button.addEventListener('click', () => {
        this.data.alignment = dir;
        this._applyAlignment();
      });
      return button;
    }
  
    /** 실제 정렬 스타일 적용 */
    _applyAlignment() {
      // 1) 모든 버튼 선택 상태 갱신
      this.buttons.forEach(b => {
        b.classList.toggle('active', b.dataset.dir === this.data.alignment);
      });
  
      // 2) 블록 최상위 holder에 data-align + CSS 클래스 부여
      const holder = this.block.holder;   // <div class="ce-block">
      holder.dataset.align = this.data.alignment;
    }
  }