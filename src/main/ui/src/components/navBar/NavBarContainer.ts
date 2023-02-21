import styled from 'styled-components';

const NavBarContainer = styled.div`
    display: flex;
    flex-direction: row;
    gap: 25px;
    align-items: center;
    position: sticky;
    top: 0;
    z-index: 101;
    width: 59%;
    
    button, .MuiSvgIcon-root {
        color: white;
        font-size: 50px;
    }
  
    .iconContainer {
      .MuiSvgIcon-root {
        &:hover {
          cursor: pointer;
          background-color: rgba(0, 0, 0, 0.04);
          border-radius: 30px;
        }
      }
    }

    .DisciplinesList, .BrandsList {
      color: #5a0289;
      font-size: 20px;
    }
`;

export default NavBarContainer;